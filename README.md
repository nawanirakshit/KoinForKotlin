KOIN + Kotlin + MVVM + Retrofit + Room Persistance + Shared Preferences + RxAndroid

Repository on how to implement koin for Dependency Injection. 
I am implementing Retrofit, Room Persistance, Shared Preferences and ViewModel(MVVM) using DI.

Use below dependencies to start working (Update versions according to the library)

    //Room Persistence Lib for saving Data in DB
    implementation "androidx.room:room-runtime:$room"
    kapt "androidx.room:room-compiler:$room"
    implementation "androidx.room:room-ktx:$room"
    implementation 'androidx.lifecycle:lifecycle-livedata:2.2.0'

    // Retrofit as our REST service
    implementation "com.squareup.retrofit2:retrofit:$retrofit"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit"
    implementation 'com.squareup.okhttp3:logging-interceptor:4.3.0'

    //Koin 
    implementation "org.koin:koin-android:$koin"
    implementation "org.koin:koin-androidx-viewmodel:$koin"

    //RxAndroid 
    implementation 'io.reactivex.rxjava2:rxandroid:2.1.0'


Feel free to us this code/files in your project.

Read my whole here https://blog.rakshit.tech/blog/2020/03/12/koin-a-dependency-injection-for-androidkotlin/


