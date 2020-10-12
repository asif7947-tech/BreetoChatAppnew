package com.zamba.berreto.interfaces;

import android.view.View;

import com.zamba.berreto.models.Group;
import com.zamba.berreto.models.User;

/**
 * Created by a_man on 5/10/2017.
 */

public interface ChatItemClickListener {
    void onChatItemClick(String chatId, String chatName, int position, View userImage);

    void onChatItemUserClick(String chatId, String chatName,String chatNamedisplay, int position, View userImage);

    void onChatItemClick(Group group, int position, View userImage);

    void placeCall(boolean callIsVideo, User user);
}
