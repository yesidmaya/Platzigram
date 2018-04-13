package com.platzi.platzigram.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.platzigram.R;
import com.platzi.platzigram.modelo.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yesidmaya on 9/04/18.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{ // despues de colocar los valores de <> sigue en rojo implementamos los metodos dando en el bombillo

    // implementamos variables

    private ArrayList<Picture> pictures; // recibimos el arreglo en esta variable de pictures que puede llegar de internet o de base de datos
    private int resource; // el recurso sera el layout nuestro cardview
    private Activity activity; // actividad desde donde se esta llamando la clase PictureAdapterRecyclerView. el objeto activity ayuda a organizar la imagen

    // vamos a hacer un constructor con las anteriores variables: en mac control + enter

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // inicializa la clase PictureViewHolder ya que necesito entregarle el Cardview
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false); // es parecido en lo que pasa en fragment. el codigo de xml lo estamos mostrando en codigo java los estamos combirtiendo en un view
                                                                                                            // le estamos pasando por completo el recurso
        return new PictureViewHolder(view); // le pasamos el view
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) { // se va a trabajar con tada la lista de elementos el arreglo list,
                                                                                    // se pasara la lista de datos de cada objeto de picture
        Picture picture = pictures.get(position); // positions va a recorrer nuestra array list uno a uno. cada dato se le asigna a un determinado cardview
        holder.userNameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        //Picasso.get(activity).load(picture.getPicture()).into(holder.pictureCard);
        Picasso.get().load(picture.getPicture()).into(holder.pictureCard);
    }

    @Override
    public int getItemCount() { // debuelve un conteo de cuantos elementos tengo. cuantas veces tiene que recorrer el arreglo
        return pictures.size();
    } // esta clase se va a consentrar en un Cardview a la vez
    // el adapter se va a encargar de sincronizar la lista etc y le vamos a pasar una coleccion de objetos.

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView userNameCard;
        private TextView timeCard;
        private TextView likeNumberCard; // instanciamos variables que se encuentran en nuestro cardview_picture

        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard     = (ImageView) itemView.findViewById(R.id.pictureCard); // si miramos el R en color rojo importamos la class con option + enter
            userNameCard    = (TextView) itemView.findViewById(R.id.userNameCard); // si miramos el R en color rojo importamos la class con option + enter
            timeCard        = (TextView) itemView.findViewById(R.id.timeCard); // si miramos el R en color rojo importamos la class con option + enter
            likeNumberCard  = (TextView) itemView.findViewById(R.id.likeNumberCard); // si miramos el R en color rojo importamos la class con option + enter

        } // vamos a definir todos los Views que componen al cardView
    } //es nuestra clase inner, va a trabajar todos y cada uno de los Views que componen a CardView
     // NOTA: para que no salga error le damos option + enter y creamos el constructor -> es importante
}
