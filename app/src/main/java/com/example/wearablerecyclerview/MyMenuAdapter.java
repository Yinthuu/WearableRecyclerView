package com.example.wearablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wearablerecyclerview.databinding.MenuItemsBinding;

import java.util.List;
/*For bonding data to WearableRecyclerView*/
public class MyMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MyMenuItem> myMenuItemList;
    MenuItemsBinding itemsBinding; //It is needed to bond the data (_) into WearableRecyclerView

    public MyMenuAdapter(List<MyMenuItem> myMenuItemList, Context context) {
        super();
        this.myMenuItemList = myMenuItemList;
    }


/*    CREATE ViewHolder objects
      Each viewholder dispaly a single MyMenuItem/Item    */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        //contents of layout XML --> View objects
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //get data from xml layout and add them into View object
        itemsBinding = MenuItemsBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemsBinding);
    }

    //start of ViewHolder inner class

    class ViewHolder extends RecyclerView.ViewHolder{
        MenuItemsBinding recyclerRowBinding;

        /*instantiate the widgets of A Row layout --> menu_items.xml*/
        public ViewHolder(MenuItemsBinding menuRowBinding) {
            super(menuRowBinding.getRoot());
            this.recyclerRowBinding = menuRowBinding;
        }

        /*bind the menu data into the supportive layout ‘menu_items.xml*/
        public void bindView(MyMenuItem objMenu){
            recyclerRowBinding.menuItem.setText(objMenu.getText());
            recyclerRowBinding.menuIcon.setImageResource(objMenu.getImage());
        }
    }
    //End of ViewHolder inner class

/*    BIND the data () to the ViewHolder   */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindView(myMenuItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return myMenuItemList.size();
    }
}


//class ViewHolder extends RecyclerView.ViewHolder{
//
//}
