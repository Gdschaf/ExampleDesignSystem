import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.radhangs.mydesignsystem.R

/**
 * The official documentation points to this file to use for the Google font certificates.
 * https://github.com/android/compose-samples/blob/main/Jetchat/app/src/main/res/values-v23/font_certs.xml
 */
private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

public val robotoFont: FontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Roboto"),
        weight = FontWeight.Normal,
        style = FontStyle.Normal,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Roboto"),
        weight = FontWeight.Bold,
        style = FontStyle.Normal,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Roboto"),
        weight = FontWeight.Normal,
        style = FontStyle.Italic,
        fontProvider = provider
    )
)

public val robotoSerifFont: FontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Roboto Serif"),
        weight = FontWeight.Normal,
        style = FontStyle.Normal,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Roboto Serif"),
        weight = FontWeight.Bold,
        style = FontStyle.Normal,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Roboto Serif"),
        weight = FontWeight.Normal,
        style = FontStyle.Italic,
        fontProvider = provider
    )
)
