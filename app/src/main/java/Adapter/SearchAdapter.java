package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthadvisorpp.R;

import java.util.List;

import Model.Foodlist;

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView name, calories;

    public SearchViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.name);
        name = (TextView)itemView.findViewById(R.id.calories);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>{

    private Context context;

    public SearchAdapter(Context context, List<Foodlist> foodlist) {
        this.context = context;
        this.foodlist = foodlist;
    }

    private List<Foodlist> foodlist;

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_search_calories,parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.name.setText(foodlist.get(position).getName());
        holder.calories.setText(foodlist.get(position).getCalories());
    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }
}
