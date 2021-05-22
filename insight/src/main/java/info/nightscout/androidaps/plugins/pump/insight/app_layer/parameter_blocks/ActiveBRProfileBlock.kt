package info.nightscout.androidaps.plugins.pump.insight.app_layer.parameter_blocks

import info.nightscout.androidaps.plugins.pump.insight.descriptors.BasalProfile
import info.nightscout.androidaps.plugins.pump.insight.descriptors.BasalProfile.Companion.fromId
import info.nightscout.androidaps.plugins.pump.insight.utils.ByteBuf

class ActiveBRProfileBlock : ParameterBlock() {

    var activeBasalProfile: BasalProfile? = null
    override fun parse(byteBuf: ByteBuf) {
        activeBasalProfile = fromId(byteBuf.readUInt16LE())
    }

    override val data: ByteBuf
        get() {
            val byteBuf = ByteBuf(2)
            activeBasalProfile?.let { byteBuf.putUInt16LE(it.id) }
            return byteBuf
        }
}