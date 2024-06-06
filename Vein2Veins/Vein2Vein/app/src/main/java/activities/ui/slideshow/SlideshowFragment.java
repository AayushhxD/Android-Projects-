package activities.ui.slideshow;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.vein2vein.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import activities.DonorFragment;
import activities.ui.gallery.Donor;

import static android.content.ContentValues.TAG;

public class SlideshowFragment extends Fragment {

    EditText name_donee, surname_donee, dob_donee, gender_donee, blood_group_donee, units_donee, location_donee, required_date_donee, mobile_donee, hospital_donee, additional_note_donee;

    Button request_button;

    DatabaseReference databaseDonees;

    private SlideshowViewModel slideshowViewModel;

    DatePickerDialog.OnDateSetListener dateSetListener;
    DatePickerDialog.OnDateSetListener date;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        name_donee = root.findViewById(R.id.name_donee);
        surname_donee = root.findViewById(R.id.surname_donee);
        dob_donee = root.findViewById(R.id.dob_donee);
        gender_donee = root.findViewById(R.id.gender_donee);
        blood_group_donee = root.findViewById(R.id.blood_group_donee);
        units_donee = root.findViewById(R.id.units_donee);
        location_donee = root.findViewById(R.id.location_donee);
        required_date_donee = root.findViewById(R.id.required_date_donee);
        mobile_donee = root.findViewById(R.id.mobile_donee);
        hospital_donee = root.findViewById(R.id.hospital_donee);
        additional_note_donee = root.findViewById(R.id.additional_note_donee);

        request_button = root.findViewById(R.id.request_button);

        databaseDonees = FirebaseDatabase.getInstance().getReference("Donees");

        dob_donee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener, year, month, day);

                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);

                String date = dayOfMonth + "/" + month + "/" +year;
                dob_donee.setText(date);
            }
        };

        required_date_donee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, date, year, month, day);

                dialog.show();
            }
        });

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);

                String date = dayOfMonth + "/" + month + "/" +year;
                required_date_donee.setText(date);
            }
        };

        request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                addDonee();
            }
        });

        return root;
    }

    private void addDonee()
    {
        String name = name_donee.getText().toString().trim();
        String surname = surname_donee.getText().toString().trim();
        String dob = dob_donee.getText().toString().trim();
        String gender = gender_donee.getText().toString().trim();
        String blood_group = blood_group_donee.getText().toString().trim();
        String units = units_donee.getText().toString().trim();
        String location = location_donee.getText().toString().trim();
        String required_date = required_date_donee.getText().toString().trim();
        String mobile = mobile_donee.getText().toString().trim();
        String hospital = hospital_donee.getText().toString().trim();
        String additional_note = additional_note_donee.getText().toString().trim();

        if (name.isEmpty())
        {
            showError(name_donee, "This space needs to be filled!");
        } else if (surname.isEmpty())
        {
            showError(surname_donee, "This space needs to be filled!");
        } else if (dob.isEmpty())
        {
            showError(dob_donee, "This space needs to be filled!");
        } else if (gender.isEmpty())
        {
            showError(gender_donee, "This space needs to be filled!");
        } else if (blood_group.isEmpty())
        {
            showError(blood_group_donee, "This space needs to be filled!");
        } else if (units.isEmpty())
        {
            showError(units_donee, "This space needs to be filled!");
        } else if (location.isEmpty())
        {
            showError(location_donee, "This space needs to be filled!");
        } else if (required_date.isEmpty())
        {
            showError(required_date_donee, "This space needs to be filled!");
        } else if (mobile.isEmpty())
        {
            showError(mobile_donee, "This space needs to be filled!");
        } else if (hospital.isEmpty())
        {
            showError(hospital_donee, "This space needs to be filled!");
        } else if (additional_note.isEmpty())
        {
            showError(additional_note_donee, "This space needs to be filled!");
        } else
        {
            String id = databaseDonees.push().getKey();
            Donee donee = new Donee(id, name, surname, dob, gender, mobile, blood_group, units, location, required_date, hospital, additional_note);

            databaseDonees.child(id).setValue(donee);

            Toast.makeText(getContext(), "Your request has been posted", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}