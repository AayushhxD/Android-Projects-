package activities.ui.gallery;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vein2vein.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    EditText name_donor, surname_donor, dob_donor, gender_donor, email_donor, mobile_donor, blood_group_donor, address_donor, last_date_donor;

    Button donate_button;

    DatabaseReference databaseDonors;

    DatePickerDialog.OnDateSetListener dateSetListener;
    DatePickerDialog.OnDateSetListener date;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        name_donor = root.findViewById(R.id.name_donor);
        surname_donor = root.findViewById(R.id.surname_donor);
        dob_donor = root.findViewById(R.id.dob_donor);
        gender_donor = root.findViewById(R.id.gender_donor);
        email_donor = root.findViewById(R.id.email_donor);
        mobile_donor = root.findViewById(R.id.mobile_donor);
        blood_group_donor = root.findViewById(R.id.blood_group_donor);
        address_donor = root.findViewById(R.id.address_donor);
        last_date_donor = root.findViewById(R.id.last_date_donor);

        donate_button = root.findViewById(R.id.donate_button);

        databaseDonors = FirebaseDatabase.getInstance().getReference("Donors");

        dob_donor.setOnClickListener(new View.OnClickListener() {
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
                dob_donor.setText(date);
            }
        };

        last_date_donor.setOnClickListener(new View.OnClickListener() {
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
                last_date_donor.setText(date);
            }
        };

        donate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDonor();
            }
        });

        return root;
    }

    private void addDonor(){
        String name = name_donor.getText().toString().trim();
        String surname = surname_donor.getText().toString().trim();
        String dob = dob_donor.getText().toString().trim();
        String gender = gender_donor.getText().toString().trim();
        String email = email_donor.getText().toString().trim();
        String mobile = mobile_donor.getText().toString().trim();
        String blood_group = blood_group_donor.getText().toString().trim();
        String address = address_donor.getText().toString().trim();
        String last_donate_date = last_date_donor.getText().toString().trim();

        if (name.isEmpty())
        {
            showError(name_donor, "This space needs to be filled!");
        } else if (surname.isEmpty())
        {
            showError(surname_donor, "This space needs to be filled!");
        } else if (dob.isEmpty())
        {
            showError(dob_donor, "This space needs to be filled!");
        } else if (gender.isEmpty())
        {
            showError(gender_donor, "This space needs to be filled!");
        } else if (email.isEmpty())
        {
            showError(email_donor, "This space needs to be filled!");
        } else if (!email.contains("@"))
        {
            showError(email_donor, "Please enter a valid Email Id");
        } else if (mobile.isEmpty())
        {
            showError(mobile_donor, "This space needs to be filled!");
        } else if (mobile.length() < 10)
        {
            showError(mobile_donor, "Please enter a valid Mobile No.");
        } else if (blood_group.isEmpty())
        {
            showError(blood_group_donor, "This space needs to be filled!");
        } else if (address.isEmpty())
        {
            showError(address_donor, "This space needs to be filled!");
        } else if (last_donate_date.isEmpty())
        {
            showError(last_date_donor, "This space needs to be filled!");
        } else
        {
            String id = databaseDonors.push().getKey();
            Donor donor = new Donor(id, name, surname, dob, gender, email, mobile, blood_group, address, last_donate_date);

            databaseDonors.child(id).setValue(donor);

            Toast.makeText(getContext(), "You have successfully registered as a donor!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}