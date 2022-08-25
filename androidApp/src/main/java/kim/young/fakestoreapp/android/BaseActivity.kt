package kim.young.fakestoreapp.android

import androidx.activity.ComponentActivity
import kim.young.fakestoreapp.shared.IExecutorScope

abstract class BaseActivity : ComponentActivity() {
    protected abstract val vm: Array<IExecutorScope>

    override fun onDestroy() {
        vm.forEach { it.cancel() }
        super.onDestroy()
    }
}