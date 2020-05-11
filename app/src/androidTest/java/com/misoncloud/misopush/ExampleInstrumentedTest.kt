package com.misoncloud.misopush

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext


//        MisoPush.getInstance().onRecvPush("ck06", "test_module_android_" + (0 until 99999).random())
        MisoPush.getInstance().insertTarget("b5508f8a848311eabc550242ac130003", "uk", "tk", "1.1.1")

    }

}
