package br.edu.ifsc.listagempersonalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

class FrutaAdapter extends ArrayAdapter {
    Context myContext;
    int myRecurso;

    public FrutaAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.myContext = context;
        this.myRecurso = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView= inflater.inflate(myRecurso, parent, false);

        //Associando identificadores a objetos do layout
        TextView tvCodigo = (TextView) convertView.findViewById(R.id.codigo);
        TextView tvNome = (TextView) convertView.findViewById(R.id.nome);
        TextView tvPreco = (TextView) convertView.findViewById(R.id.preco);
        TextView tvPrecoVenda =(TextView) convertView.findViewById(R.id.preco_venda);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView);

        Fruta fruta =  (Fruta) getItem(position);

        NumberFormat nf = new DecimalFormat("#,###.00");
        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(nf.format (fruta.getPreco()));
        tvPrecoVenda.setText(nf.format (fruta.getPreco_venda()));
        imgView.setImageResource(fruta.getImagem());

        return convertView;
    }
}
