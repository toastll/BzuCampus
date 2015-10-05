package cn.edu.bzu.bzucampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.edu.bzu.bzucampus.R;

/**
 * TopNews新闻适配器
 * Created by monster on 2015/10/5.
 */
public class TopNewsRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> mData;
    private Context context;
    private LayoutInflater mInflater;

    /**
     * 声明一个接口，用于实现点击事件
     */
    public interface  OnItemClickListener{
        void OnItemClick(int position,View view);
        void OnItemLongClick(int position,View view);
    }

    private OnItemClickListener mOnItemClickListener;

    public  void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }


    /**
     * 构造方法的实现
     * @param mData
     * @param context
     */
    public TopNewsRecyclerViewAdapter(List<String> mData,Context context){
        this.mData=mData;
        this.context=context;
        mInflater=LayoutInflater.from(context);
    }

    //创建ViewHloder对象
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.topnews_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(mData.get(position));

        if (mOnItemClickListener!=null){

            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int LayoutPosition=holder.getLayoutPosition(); //得到布局的position
                    mOnItemClickListener.OnItemClick(LayoutPosition,holder.itemView);

                }
            });

            //longclickListener
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int LayoutPosition=holder.getLayoutPosition(); //得到布局的position
                    mOnItemClickListener.OnItemLongClick(LayoutPosition,holder.itemView);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}


/**
 * ViewHolder类，这个类的作用主要用于实例化控件
 */
class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv; //声明控件

    public MyViewHolder(View itemView) {
        super(itemView);
        /**初始化控件**/
        tv = (TextView) itemView.findViewById(R.id.tv);
    }
}
