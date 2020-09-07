package com.zamba.testchat.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zamba.testchat.R;
import com.zamba.testchat.interfaces.ChatItemClickListener;
import com.zamba.testchat.models.Chat;
import com.zamba.testchat.models.User;

import java.util.ArrayList;

public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserAdapter.BaseViewHolder> {
    private Context context;

    private ArrayList<User> dataList;


    private ChatItemClickListener itemClickListener;

    public SearchUserAdapter(@NonNull Context context, @Nullable ArrayList<User> users) {

        if (context instanceof ChatItemClickListener) {
            this.itemClickListener = (ChatItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ChatItemClickListener");
        }
        this.context = context;
        this.dataList = users;

    } public SearchUserAdapter(@NonNull Context context) {


        this.context = context;


    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new UsersViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu_user, parent, false));
          }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder instanceof UsersViewHolder) {
            ((UsersViewHolder) holder).setData(dataList.get(position));


        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    class UserInviteHeaderViewHolder extends BaseViewHolder {
        private TextView inviteTitle, inviteMessage;

        UserInviteHeaderViewHolder(final View itemView) {
            super(itemView);
            inviteTitle = itemView.findViewById(R.id.inviteTitle);
            inviteMessage = itemView.findViewById(R.id.inviteMessage);
            inviteMessage.setSelected(true);
            inviteTitle.setSelected(true);
        }
    }

    class UsersViewHolder extends BaseViewHolder {
        private ImageView userImage;
        private TextView userName, inviteText;
        RelativeLayout  main_layout;

        UsersViewHolder(final View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
            userName = itemView.findViewById(R.id.user_name);
            inviteText = itemView.findViewById(R.id.inviteText);
            main_layout = itemView.findViewById(R.id.main_layout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("StringFormatMatches")
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != -1) {




                        itemClickListener.onChatItemClick(dataList.get(pos).getId(), dataList.get(pos).getNameToDisplay(), pos, userImage);


                    }
                }
            });
        }

        public void setData(User user) {
            userName.setText(user.getUser_name());
            inviteText.setVisibility(user.isInviteAble() ? View.VISIBLE : View.GONE);
            Glide.with(context).load(user.getImage()).apply(new RequestOptions().placeholder(R.drawable.yoohoo_placeholder)).into(userImage);
            userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }
}
