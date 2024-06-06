package activities.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Please fill in the following details correctly. This will help to protect you and the patient who receives your blood.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}