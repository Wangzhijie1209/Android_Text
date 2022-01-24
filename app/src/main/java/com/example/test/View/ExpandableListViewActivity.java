package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.R;

/**
 * 可展开的列表组件  ExpandableListView
 * ExpandableListView是ListView的子类,它在普通ListView的基础上进行了扩展,它把应用中的列表项分为几组，
 * 每组里又可包含多个列表项
 * ExpandableListView的用法与普通的ListView的用法非常相似,只是ExpandableListView所显示的列表项应该由
 * ExpandableListAdapter提供,ExpandableListAdapter也是一个接口,该接口下提供与Adapter类似的是,实现ExpandableListAdapter
 * 也有如下三种常用方式:
 * 扩展BaseExpandableListAdapter 实现 ExpandableListAdapter
 * 使用SimpleExpandableListAdapter将两个List集合包装成ExpandableListAdapter
 * 使用SimpleCursorTreeAdapter将Cursor中的数据包装成了SimpleCursorTreeAdapter
 * <p>
 * ExpandableListView常用XML属性
 * XML属性                        说明
 * android:childDivider          指定各组内各子列表项之间的分隔条
 * android:childIndicator        显示在子列表项旁边的Drawable对象
 * android:childIndicatorEnd     设置每个子列表项的结束边界符,该属性为任意长度值
 * android:childIndicatorLeft    设置每个子列表项的左边边界符,该属性为任意长度值
 * android:childIndicatorRight   设置每个子列表项的右边界符,该属性为任意长度值
 * android:childIndicatorStart   设置每个子列表项的起始边界符,该属性为任意长度值
 * android:groupIndicator        显示在组列表旁边的Drawable对象
 * android:indicatorEnd          设置每个组列表项的结束边界符,该属性为任意长度值
 * android:indicatorLeft         设置每个组列表项的左边界符,该属性为任意长度值
 * android:indicatorRight        设置每个组列表项的右边界符,该属性为任意长度值
 * android:indicatorStart        设置每个组列表项的起始边界符,该属性为任意长度值
 */
public class ExpandableListViewActivity extends AppCompatActivity {

    /**
     * 为了优化getChildView() 和 getGroupView()方法的性能,程序在这两个方法中首先判断convertView参数是否为null,该参数代表Android系统所缓存的
     * 组或列表项组件,只有当convertView组件为null时，程序才重新创建组或列表项组件.不管是使用缓存的组或列表项组件,还是使用重新创建的的组或列表项组件,
     * 程序都需重新设置这些组件所显示的数据
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        //创建一个BaseExpandableListAdapter对象
        BaseExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logs = new int[]{R.drawable.a, R.drawable.b, R.drawable.c};
            String[] armTypes = new String[]{"神族兵种", "虫族兵种", "人族兵种"};
            String[][] arms = new String[][]{
                    new String[]{"狂战士", "阿巴", "巧克力", "杜兰特"},
                    new String[]{"瑞文", "巴科里", "凯文", "啊杜"},
                    new String[]{"曹总", "曹仁", "曹丕", "曹操"}};

            //该方法返回包含的组列表项数量
            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            //该方法返回特定组所包含的子列表项数量
            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }

            //获取指定组位置的组数据
            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }

            //获取指定组位置、指定子列表处的子列表项数据
            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }


            @Override
            public long getChildId(int i, int i1) {
                return i;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            //该方法决定每个组选项的外观 返回的view对象将做为组列表项
            //返回了一个LinearLayout对象，该LinearLayout对象里包含一个ImageView和一个TextView。因此，每个组列表项都由图片和文本组成
            //此方法返回值代表每个组的组件,
            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout ll;
                ViewHolder viewHolder;
                if (view == null) {
                    ll = new LinearLayout(ExpandableListViewActivity.this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    ImageView logo = new ImageView(ExpandableListViewActivity.this);
                    ll.addView(logo);
                    TextView textView = this.getTextView();
                    ll.addView(textView);
                    viewHolder = new ViewHolder(logo, textView);
                    ll.setTag(viewHolder);
                } else {
                    ll = (LinearLayout) view;
                    viewHolder = (ViewHolder) ll.getTag();
                }
                viewHolder.imageView.setImageResource(logs[i]);
                viewHolder.textView.setText(getGroup(i).toString());
                return ll;
            }

            //该方法决定每个子选项的外观  返回的View对象将作为特定组、特定位置的子列表项.
            //该方法返回值代表组内各列表项的组件。
            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView;
                if (view == null) {
                    textView = this.getTextView();
                } else {
                    textView = (TextView) view;
                }
                textView.setText(getChild(i, i1).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            private TextView getTextView() {
                TextView textView = new TextView(ExpandableListViewActivity.this);
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
                textView.setPadding(36, 10, 0, 10);
                textView.setTextSize(20f);
                return textView;
            }
        };
        ExpandableListView expandableListView = findViewById(R.id.list);
        expandableListView.setAdapter(adapter);
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(ImageView imageView, TextView textView) {
            this.imageView = imageView;
            this.textView = textView;
        }

    }
}


