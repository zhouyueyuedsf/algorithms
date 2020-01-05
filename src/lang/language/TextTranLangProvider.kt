package lang.language

import common.CommonLanguage

class TextTranLangProvider private constructor() : LangProvider{
    override fun supportLanguages(): List<CommonLanguage> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun recentUsedLanguages(): List<CommonLanguage> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val instance: TextTranLangProvider by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            TextTranLangProvider()
        }
    }
}