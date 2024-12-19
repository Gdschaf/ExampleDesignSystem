package com.radhangs.mydesignsystem.theme.tokens.core

import androidx.compose.ui.graphics.Color

@CoreTokensOptIn
public class CoreTokens {
    public val colors: CoreColorTokens = CoreColorTokens()

    public inner class CoreColorPalette(private val colors: Map<Int, Color>) {
        public operator fun invoke(shade: Int): Color {
            return colors[shade] ?: error("Shade $shade not found") // throw IllegalArgumentException("Invalid shade: $shade")
        }
    }

    public inner class CoreColorTokens {
        public var gray: CoreColorPalette = CoreColorPalette(
            mapOf(
                0 to Color(0xFFFFFFFF),
                5 to Color(0xFFF9FAFB),
                10 to Color(0xFFF3F4F6),
                20 to Color(0xFFE5E7EB),
                30 to Color(0xFFD1D5DB),
                40 to Color(0xFF9CA3AF),
                50 to Color(0xFF6B7280),
                60 to Color(0xFF4B5563),
                70 to Color(0xFF374151),
                80 to Color(0xFF1F2937),
                90 to Color(0xFF111827),
                100 to Color(0xFF000000)
            )
        )

        public var red: CoreColorPalette = CoreColorPalette(
            mapOf(
                0 to Color(0xFFFF0000),
                5 to Color(0xFFFFF5F5),
                10 to Color(0xFFFED7D7),
                20 to Color(0xFFFEB2B2),
                30 to Color(0xFFFC8181),
                40 to Color(0xFFF56565),
                50 to Color(0xFFE53E3E),
                60 to Color(0xFFC53030),
                70 to Color(0xFF9B2C2C),
                80 to Color(0xFF742A2A)
            )
        )

        public var blue: CoreColorPalette = CoreColorPalette(
            mapOf(
                5 to Color(0xFFEBF8FF),
                10 to Color(0xFFBEE3F8),
                20 to Color(0xFF90CDF4),
                30 to Color(0xFF63B3ED),
                40 to Color(0xFF4299E1),
                50 to Color(0xFF3182CE),
                60 to Color(0xFF2B6CB0),
                70 to Color(0xFF2C5282),
                80 to Color(0xFF2A4365)
            )
        )

        public var green: CoreColorPalette = CoreColorPalette(
            mapOf(
                5 to Color(0xFFF0FFF4),
                10 to Color(0xFFC6F6D5),
                20 to Color(0xFF9AE6B4),
                30 to Color(0xFF68D391),
                40 to Color(0xFF48BB78),
                50 to Color(0xFF38A169),
                60 to Color(0xFF2F855A),
                70 to Color(0xFF276749),
                80 to Color(0xFF22543D)
            )
        )

        public var yellow: CoreColorPalette = CoreColorPalette(
            mapOf(
                5 to Color(0xFFFFFFF0),
                10 to Color(0xFFFEFCBF),
                20 to Color(0xFFFAF089),
                30 to Color(0xFFF6E05E),
                40 to Color(0xFFECC94B),
                50 to Color(0xFFD69E2E),
                60 to Color(0xFFB7791F),
                70 to Color(0xFF975A16),
                80 to Color(0xFF744210)
            )
        )
    }
}


