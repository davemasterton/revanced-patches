package app.revanced.patches.duolingo.fullhearts

import app.revanced.patches.duolingo.fullhearts.initializeAlwaysFullHeartsFingerprint
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.TwoRegisterInstruction

@Suppress("unused")
val enableDebugMenuPatch = bytecodePatch(
    name = "Always full hearts",
    use = false,
) {
    compatibleWith("com.duolingo"("6.8.3", "6.9.0"))

    execute {
        initializeAlwaysFullHeartsFingerprint.method.apply {
            val insertIndex = initializeAlwaysFullHeartsFingerprint.patternMatch!!.endIndex - 1
            val register = getInstruction<TwoRegisterInstruction>(insertIndex).registerA

            addInstructions(
                insertIndex,
                "const v$register #int 5",
            )
        }
    }
}
