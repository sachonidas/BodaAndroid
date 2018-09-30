package es.luissachaarancibiabazan.boda3;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Confirmacion extends Fragment {

    public EditText nombre, apellidos, alergias;
    public RadioButton siBtn, noBtn, siBus, noBus;
    public static int VISIBLE = 0;
    public static int INVISIBLE = 4;
    public Button btnEnviar;


    public Confirmacion() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmacion, container, false);

        btnEnviar = (Button)view.findViewById(R.id.btnEnviar);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

        nombre = (EditText)view.findViewById(R.id.nombre);
        apellidos = (EditText)view.findViewById(R.id.apellidos);
        alergias = (EditText)view.findViewById(R.id.alergiasTxt);

        siBtn = (RadioButton)view.findViewById(R.id.siBtn);
        noBtn = (RadioButton)view.findViewById(R.id.noBtn);
        siBus = (RadioButton)view.findViewById(R.id.siBus);
        noBus = (RadioButton)view.findViewById(R.id.noBus);

        noBtn.setChecked(true);
        alergias.setVisibility(View.INVISIBLE);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i)
                {
                    case R.id.siBtn:
                        alergias.setVisibility(View.VISIBLE);

                        break;
                    case R.id.noBtn:
                        alergias.setVisibility(View.GONE);
                        break;
                }

            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] TO = {"lsachaabazan@gmail.com"};
                String[] CC = {"lsachaabazan@gmail.com"};
                String nombreString = nombre.getText().toString()+ ", " + apellidos.getText().toString();
                String alergiaString = "";
                String alergiaRespuesta = "";
                String bus = "";
                String respuesta = "";


                if (siBtn.isChecked() == true){
                    alergiaRespuesta = alergias.getText().toString();
                    alergiaString = "Si, "+alergiaRespuesta;
                }else{
                    alergiaString = "No";
                    alergiaRespuesta = "";
                }
                if (siBus.isChecked() == true){
                    bus = "Si";
                }else{
                    bus = "No";
                }

                respuesta = "Invitado: "+ nombreString + " \n " + "Alergias: " + alergiaString + "\n Autobus: " + bus;

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto: "));
                emailIntent.setType("text/plan");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Confirmación asistencia");
                emailIntent.putExtra(Intent.EXTRA_TEXT, respuesta);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
                    Toast.makeText(getContext(), "Confirmación Enviada!!!", Toast.LENGTH_SHORT).show();
                    //getActivity().finish();
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(getContext(),
                            "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
                }



            }
        });
        return view;


    }


    @Override
    public void onStart() {
        super.onStart();
    }


}
