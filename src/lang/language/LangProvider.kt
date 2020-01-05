package lang.language

import common.CommonLanguage

interface LangProvider {
    /**
     * 生成数据
     */
    fun supportLanguages(): List<CommonLanguage>
    fun recentUsedLanguages(): List<CommonLanguage>
}
