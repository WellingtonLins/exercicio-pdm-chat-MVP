package ag.utacapp.components;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ag.utacapp.R;
import ag.utacapp.model.Message;


public class MessagesAdapter extends BaseAdapter {
    List<Message> list = new ArrayList<Message>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //recuperando o item
        Message m = list.get(i);
        //opção 1 - recuperando um elemento de item via findViewById (todo necessário alterar o componente)
        //DashboardActivity activity = (DashboardActivity) viewGroup.getContext();
        //ViewGroup item = (ViewGroup) activity.findViewById(R.id.lvMsgItem);
        //opção 2 - recuperando um elemento de item via inflate (todo necessário desfazer alteração da opção 1)
        Context ctx = viewGroup.getContext();
        LayoutInflater mInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout item = (LinearLayout) mInflater.inflate(R.layout.comp_listview_item, null);
        ((TextView) item.findViewById(R.id.label)).setText(m.getName().substring(0, 2));
        ((TextView) item.findViewById(R.id.tvUserName)).setText(m.getName());
        ((TextView) item.findViewById(R.id.tvMessage)).setText(m.getMessage());
        //retornando um elemento
        return item;
    }

    public void update(Message m){
        if (!list.isEmpty()) {
            Message m0 = list.get(0);
            list.remove(m0);
        }
        list.add(m);
    }

}
