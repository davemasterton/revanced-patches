package app.revanced.patches.duolingo.fullhearts

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val initializeAlwaysFullHeartsFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL, AccessFlags.CONSTRUCTOR)
    parameters("Ljava/time/Duration;")
    returns("I")
    opcodes(Opcode.INVOKE_DIRECT_RANGE)
}
