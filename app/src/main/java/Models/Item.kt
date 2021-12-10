package Models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Item : BaseObservable() {
    private var selectedItemPosition = 0
    /*La anotación enlazable debe aplicarse a cualquier método de acceso getter de una Observableclase. Bindable generará un campo en la clase BR para identificar el campo que ha cambiado.*/
    @Bindable
    fun getSelectedItemPosition(): Int {
        return selectedItemPosition
    }
    fun setSelectedItemPosition(selectedItemPosition: Int) {
        this.selectedItemPosition = selectedItemPosition
        notifyPropertyChanged(BR.selectedItemPosition)
    }
}