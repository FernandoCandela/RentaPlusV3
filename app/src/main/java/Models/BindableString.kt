package Models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import java.util.*

class BindableString : BaseObservable(){
    private var value : String? =null
    /*BaseObservable que puede ampliar. La clase de datos es responsable de notificar cuándo cambian las propiedades. Esto se hace asignando una anotación @Bindable al captador y notificándolo en el definidor. Este oyente se invoca en cada actualización y actualiza las vistas correspondientes*/
    @Bindable
    fun getValue():String{
        return if (value != null) value!! else ""
    }
    fun setValue(value: String){
        if(!Objects.equals(this.value, value)){
            this.value = value
            notifyPropertyChanged(BR.value)
        }
    }
}