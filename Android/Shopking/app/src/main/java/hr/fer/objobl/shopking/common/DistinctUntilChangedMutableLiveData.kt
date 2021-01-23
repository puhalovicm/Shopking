package hr.fer.objobl.shopking.common

import androidx.lifecycle.MutableLiveData

class DistinctUntilChangedMutableLiveData<T> : MutableLiveData<T> {

    constructor(): super()

    constructor(item: T): super(item)

    override fun setValue(value: T?) {
        if (value != this.value) {
            super.setValue(value)
        }
    }
}
