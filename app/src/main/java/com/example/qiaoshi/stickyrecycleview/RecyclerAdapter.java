package com.example.qiaoshi.stickyrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.stickylib.PinnedHeaderAdapter;

import java.util.List;

public class RecyclerAdapter extends PinnedHeaderAdapter<RecyclerView.ViewHolder> {

	private static final int VIEW_TYPE_ITEM_TIME = 0;
	private static final int VIEW_TYPE_ITEM_CONTENT = 1;
	private static final int VIEW_TYPE_ITEM_BANNER = 2;

	private List<String> mDataList;

	private myItemOclick itemOclick;

	public void SetItemOnclick(myItemOclick itemOclick){
		this.itemOclick = itemOclick;

	}



	public RecyclerAdapter(List<String> dataList) {
		mDataList = dataList;
	}

	public void setData(List<String> dataList) {
		mDataList = dataList;
		notifyDataSetChanged();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (viewType == VIEW_TYPE_ITEM_TIME) {
			return new TitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.shailayout, parent, false));
		} else if (viewType == VIEW_TYPE_ITEM_BANNER) {
			return new BannerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item, parent, false));
		} else {
			return new ContentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
			if (holder instanceof TitleHolder) {
				//Log.e("TAGSSS","4---"+holder.itemView.getTop());

                //第一个
				TitleHolder titleHolder = (TitleHolder) holder;
				titleHolder.one.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
                        int top= holder.itemView.getTop();

                        itemOclick.myItemOnclick(v, 0,top);
                      //  Log.e("TAGSSS","1---"+v.getTop());

					}
				});
				//第二个
				titleHolder.two.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
                        int top= holder.itemView.getTop();


                        itemOclick.myItemOnclick(v, 1,top);
                       // Log.e("TAGSSS","2---"+v.getTop());


                    }
				});
				//第三个
				titleHolder.three.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

                        int top= holder.itemView.getTop();

                        itemOclick.myItemOnclick(v, 2,top);
                        //Log.e("TAGSSS","3---"+v.getTop());


                    }
				});

			}

	}

	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	@Override
	public int getItemViewType(int position) {
		if (position == 1) {
			return VIEW_TYPE_ITEM_TIME;
		} else if (position == 0) {
			return VIEW_TYPE_ITEM_BANNER;
		} else {
			return VIEW_TYPE_ITEM_CONTENT;
		}
	}

	@Override
	public boolean isPinnedPosition(int position) {
		//设置悬浮的位置
		return getItemViewType(position) == VIEW_TYPE_ITEM_TIME;
	}

	static class ContentHolder extends RecyclerView.ViewHolder {

		TextView mTextTitle;

		ContentHolder(View itemView) {
			super(itemView);
			//mTextTitle = itemView.findViewById(R.id.text_adapter_content_name);
		}
	}

	static class TitleHolder extends RecyclerView.ViewHolder {

		TextView one;
		TextView two;
		TextView three;

		TitleHolder(View itemView) {
			super(itemView);
			one = itemView .findViewById(R.id.one);
			two = itemView .findViewById(R.id.two);
			three = itemView .findViewById(R.id.three);

		}
	}

	static class BannerHolder extends RecyclerView.ViewHolder {
		public BannerHolder(View itemView) {
			super(itemView);
		}
	}

	//增加item点击事件
	//点击回到顶部的位置
public  interface  myItemOclick{
		void myItemOnclick(View view, int id, int scrollpositon);
	}
}