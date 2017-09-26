package padula.delaiglesia.dam.isi.frsf.lab03;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by st on 19/09/2017.
 */
public class ViewHolder {

    public  TextView nombreEmpresa;
    public  TextView horas;
    public  TextView nombreTrabajo;
    public  TextView precioHora;
    public  TextView fechaFin;
    public  CheckBox requiereIngles;

    ViewHolder(View row, Trabajo t){
        nombreTrabajo = (TextView) row.findViewById(R.id.nombrePuesto);
        nombreTrabajo.setText(t.getCategoria().getDescripcion());

        nombreEmpresa = (TextView) row.findViewById(R.id.nombreEmpresa);
        nombreEmpresa.setText(t.getDescripcion());

        horas = (TextView) row.findViewById(R.id.horas);
        horas.setText("Horas " + t.getHorasPresupuestadas().toString() + " Max");

        precioHora = (TextView) row.findViewById(R.id.precioHora);
        precioHora.setText("$/Hora: " + t.getPrecioMaximoHora().toString());

        fechaFin = (TextView) row.findViewById(R.id.fechaFin);
        fechaFin.setText("Fecha fin: " + t.getFechaEntrega().toString());

        requiereIngles = (CheckBox) row.findViewById(R.id.ingles);
        requiereIngles.setChecked(t.getRequiereIngles());
    }
}
