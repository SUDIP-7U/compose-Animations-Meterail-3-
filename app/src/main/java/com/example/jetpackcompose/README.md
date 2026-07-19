
dependencies {
    // Core Compose BOM (version গুলো auto-manage করে)
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))

    // Jetpack Compose UI
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Material 3
    implementation("androidx.compose.material3:material3")

    // Material Icons Extended
    implementation("androidx.compose.material:material-icons-extended")

    // Compose Animation
    implementation("androidx.compose.animation:animation")
    implementation("androidx.compose.animation:animation-graphics")
    implementation("androidx.compose.animation:animation-core")

    // Activity Compose
    implementation("androidx.activity:activity-compose:1.9.3")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    // Debug tools
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
```

### build.gradle (Groovy version হলে)

```groovy
dependencies {
    implementation platform('androidx.compose:compose-bom:2024.12.01')

    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-graphics'
    implementation 'androidx.compose.ui:ui-tooling-preview'

    implementation 'androidx.compose.material3:material3'
    implementation 'androidx.compose.material:material-icons-extended'

    implementation 'androidx.compose.animation:animation'
    implementation 'androidx.compose.animation:animation-graphics'
    implementation 'androidx.compose.animation:animation-core'

    implementation 'androidx.activity:activity-compose:1.9.3'

    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.8.7'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7'

    debugImplementation 'androidx.compose.ui:ui-tooling'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}
```

## ⚙️ compileOptions & Compose Setup

```kotlin
android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15" // আপনার Kotlin version অনুযায়ী adjust করুন
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
```

## 🎨 ব্যবহারের উদাহরণ (Usage Example)

### Material 3 + Extended Icon

```kotlin
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

@Composable
fun FavoriteIcon() {
    Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = "Favorite",
        tint = MaterialTheme.colorScheme.primary
    )
}
```

### Compose Animation

```kotlin
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

@Composable
fun AnimatedBox(visible: Boolean) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        // আপনার Composable content
    }
}
```

## 📁 প্রজেক্ট স্ট্রাকচার (Suggested)

```
app/
 ├─ src/main/java/com/example/app/
 │   ├─ ui/
 │   │   ├─ theme/       # Material 3 theme, colors, typography
 │   │   ├─ components/  # Reusable Composables
 │   │   └─ screens/     # App screens
 │   └─ MainActivity.kt
 └─ build.gradle.kts
```

## 📝 নোট

- `compose-bom` ব্যবহার করলে সব Compose library-র version একসাথে manage হয়, তাই আলাদা version number দেওয়ার দরকার হয় না।
- `material-icons-extended` library-টা সাইজে বড়, শুধু দরকার হলে ব্যবহার করুন।
- সর্বশেষ ভার্সন নম্বর জানতে [Google Maven Repository](https://maven.google.com/) চেক করে নিতে পারেন।

## 📄 License

এই প্রজেক্টটি ব্যক্তিগত/শিক্ষামূলক ব্যবহারের জন্য।
