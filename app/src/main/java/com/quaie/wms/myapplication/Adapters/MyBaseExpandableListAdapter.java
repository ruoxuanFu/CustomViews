package com.quaie.wms.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quaie.wms.myapplication.Bean.Child;
import com.quaie.wms.myapplication.Bean.Group;
import com.quaie.wms.myapplication.R;

import java.util.ArrayList;

/**
 * Created by yue on 2017/2/3.
 * 　　　　　　　  ┏┓　 ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　     ┃
 * 　　　　　　　┃　　　━　    ┃ ++ + + +
 * 　　　　　　 ████━████     ┃++  ++
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃  +  +
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * 可折叠listview的适配器
 */

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private ArrayList<Group> groupData;
    private ArrayList<ArrayList<Child>> childData;
    private Context mContext;

    public MyBaseExpandableListAdapter(ArrayList<Group> groupData, ArrayList<ArrayList<Child>> childData, Context mContext) {
        this.groupData = groupData;
        this.childData = childData;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public static class ViewHolderGroup {
        private TextView group_tv_name;
    }

    public static class ViewHolderChild {
        private ImageView child_img_icon;
        private TextView child_tv_name;
    }

    //取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderGroup viewHolderGroup;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_group_expandablelist, parent, false);
            viewHolderGroup = new ViewHolderGroup();
            viewHolderGroup.group_tv_name = (TextView) convertView.findViewById(R.id.group_text);
            convertView.setTag(viewHolderGroup);
        } else {
            viewHolderGroup = (ViewHolderGroup) convertView.getTag();
        }

        viewHolderGroup.group_tv_name.setText(groupData.get(groupPosition).getgName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ViewHolderChild viewHolderChild;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_child_expandablelist, parent, false);
            viewHolderChild = new ViewHolderChild();
            viewHolderChild.child_img_icon = (ImageView) convertView.findViewById(R.id.child_img);
            viewHolderChild.child_tv_name = (TextView) convertView.findViewById(R.id.child_text);
            convertView.setTag(viewHolderChild);
        } else {
            viewHolderChild = (ViewHolderChild) convertView.getTag();
        }

        viewHolderChild.child_img_icon.setImageResource(childData.get(groupPosition).get(childPosition).getcImgId());
        viewHolderChild.child_tv_name.setText(childData.get(groupPosition).get(childPosition).getcName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
