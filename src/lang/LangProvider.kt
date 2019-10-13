package lang

import common.Item
import common.Lang
import common.LangToLang


class LangProvider {
    companion object {
        const val TEXT_TRANS = 1
        const val VOICE_ONLINE_TRANS = 2
        const val OCR_ONLINE = 3
        private val ENGLISH_NAME = arrayOf("Albanian",
                "Amharic",
                "Arabic",
                "Armenian",
                "Azerbaijani",
                "Basque",
                "Belarusian",
                "Bengali",
                "Bosnian",
                "Bulgarian",
                "Burmese",
                "Catalan",
                "Cebuano",
                "Chichewa",
                "Chinese Simplified",
                "Chinese Traditional",
                "Corsican",
                "Croatian",
                "Czech",
                "Danish",
                "Dutch",
                "English",
                "Esperanto",
                "Estonian",
                "Filipino",
                "Finnish",
                "French",
                "Gaelic",
                "Galician",
                "Georgian",
                "German",
                "Greek",
                "Gujarati",
                "Haitian",
                "Hausa",
                "Hawaiian",
                "Hebrew",
                "Hindi",
                "Hmong Daw",
                "Hungarian",
                "Icelandic",
                "Igbo",
                "Indonesian",
                "Irish",
                "Italian",
                "Japanese",
                "Javanese",
                "Kannada",
                "Kazakh",
                "Khmer",
                "Klingon",
                "Korean",
                "Kurdish",
                "Kyrgyz",
                "Lao",
                "Latin",
                "Latvian",
                "Levantine Arabic",
                "Lithuanian",
                "Luxembourgish",
                "Macedonian",
                "Malagasy",
                "Malay",
                "Malayalam",
                "Maltese",
                "Maori",
                "Marathi",
                "Mongolian",
                "Nepali",
                "Norwegian",
                "Pashto",
                "Persian",
                "Polish",
                "Portuguese",
                "Punjabi",
                "Querétaro Otomi",
                "Romanian",
                "Russian",
                "Samoan",
                "Serbian-Cyrillic",
                "Serbian-Latin",
                "Shona",
                "Sindhi",
                "Sinhala",
                "Slovak",
                "Slovenian",
                "Somali",
                "Southern Sotho",
                "Spanish",
                "Sundanese",
                "Swahili",
                "Swedish",
                "Tajik",
                "Tamil",
                "Telugu",
                "Thai",
                "Turkish",
                "Ukrainian",
                "Urdu",
                "Uzbek",
                "Vietnamese",
                "Welsh",
                "Western Frisian",
                "Xhosa",
                "Yiddish",
                "Yoruba",
                "Yucatec Maya",
                "Zulu")
        val LOCAL_NAME = arrayOf("Shqip",
                "አማርኛ",
                "العربية",
                "Հայերեն",
                "azərbaycan dili",
                "euskara",
                "беларуская мова",
                "বাংলা",
                "bosanski jezik",
                "български език",
                "ဗမာစာ",
                "català",
                "Cebuan",
                "chiCheŵa",
                "中文简体",
                "中文繁体",
                "corsu",
                "hrvatski jezik",
                "čeština",
                "dansk",
                "Nederlands",
                "English",
                "Esperanto",
                "eesti",
                "Pilipino",
                "suomi",
                "français",
                "Gàidhlig",
                "Galego",
                "ქართული",
                "Deutsch",
                "ελληνικά",
                "ગુજરાતી",
                "Kreyòl ayisyen",
                "Harshen Hausa",
                "Hawaiʻi",
                "עברית",
                "हिन्दी",
                "苗语",
                "magyar",
                "Íslenska",
                "Asụsụ Igbo",
                "Bahasa Indonesia",
                "Gaeilge",
                "Italiano",
                "日本語",
                "Basa Jawa",
                "ಕನ್ನಡ",
                "қазақ тілі",
                "ភាសាខ្មែរ",
                "tlhIngan Hol",
                "한국어",
                "Kurdî",
                "Кыргызча",
                "ພາສາລາວ",
                "latine",
                "latviešu valoda",
                "اللَّهْجَةُ الشَّامِيَّة",
                "lietuvių kalba",
                "Lëtzebuergesch",
                "македонски јазик",
                "fiteny malagasy",
                "Bahasa Melayu",
                "മലയാളം",
                "Malti",
                "te reo Māori",
                "मराठी",
                "Монгол хэл",
                "नेपाली",
                "Norsk",
                "پښتو",
                "فارسی",
                "polski",
                "Português",
                "ਪੰਜਾਬੀ",
                "Hñohño",
                "Română",
                "русский",
                "Sāmoa",
                "српски ",
                "српски ",
                "chiShona",
                "سنڌي",
                "සිංහල",
                "Slovenčina",
                "Slovenščina",
                "Soomaali",
                "Sesotho",
                "Español",
                "Basa Sunda",
                "Kiswahili",
                "Svenska",
                "тоҷикӣ",
                "தமிழ்",
                "తెలుగు",
                "ไทย",
                "Türkçe",
                "Українська",
                "اردو",
                "Oʻzbek",
                "Tiếng Việt",
                "Cymraeg",
                "Frysk",
                "isiXhosa",
                "ייִדיש",
                "Yorùbá",
                "Maya",
                "isiZulu")
        val ABBR = arrayOf("sq",
                "am",
                "ar",
                "hy",
                "az",
                "eu",
                "be",
                "bn",
                "bs",
                "bg",
                "my",
                "ca",
                "ceb",
                "ny",
                "zh-CN",
                "zh-TW",
                "co",
                "hr",
                "cs",
                "da",
                "nl",
                "en",
                "eo",
                "et",
                "tl",
                "fi",
                "fr",
                "gd",
                "gl",
                "ka",
                "de",
                "el",
                "gu",
                "ht",
                "ha",
                "haw",
                "he",
                "hi",
                "hmn",
                "hu",
                "is",
                "ig",
                "id",
                "ga",
                "it",
                "ja",
                "jv",
                "kn",
                "kk",
                "km",
                "tlh",
                "ko",
                "ku",
                "ky",
                "lo",
                "la",
                "lv",
                "apc",
                "lt",
                "lb",
                "mk",
                "mg",
                "ms",
                "ml",
                "mt",
                "mi",
                "mr",
                "mn",
                "ne",
                "no",
                "ps",
                "fa",
                "pl",
                "pt",
                "pa",
                "otq",
                "ro",
                "ru",
                "sm",
                "sr-Cyrl",
                "sr-Latn",
                "sn",
                "sd",
                "si",
                "sk",
                "sl",
                "so",
                "st",
                "es",
                "su",
                "sw",
                "sv",
                "tg",
                "ta",
                "te",
                "th",
                "tr",
                "uk",
                "ur",
                "uz",
                "vi",
                "cy",
                "fy",
                "xh",
                "yi",
                "yo",
                "yua",
                "zu")
        // 谷歌语音输入
        val IETF = arrayOf("bn-IN", "en-US", "gu-IN", "hi-IN", "id-ID", "ja-JP", "ko-KR", "ms-MY", "mr-IN", "ne-NP", "pa-IN", // 不支持
                "es-ES", "ta-IN", "te-IN", "th-TH", "vi-VN", "kn-IN", "ml-IN", "ur-PK", "ar-EG", "de-DE", "fr-FR", "it-IT", "ru-RU", "pt-PT",
                "tr-TR", "fil-PH", "km-KH", "lo-LA", "ps-AR", // 不支持
                "sd-PK", // 不支持
                "ig-NG", // 不支持
                "yo-NG", // 不支持
                "sw-TZ", "fa-IR", "cmn-Hans-CN", "cmn-Hans-HK", "ha-NG", // 不支持
                "or", // 不支持
                "as", // 不支持
                "ai")
        val sLangCrossList = createIntern()
        private var sLangs: ArrayList<Item>? = null
            get() {
                if (field == null) {
                    field = sLangCrossList.chooseRowListByColor(0)
                }
                return field
            }
        private var sIndexHashMap: HashMap<String, Int>? = null
            get() {
                if (field == null) {
                    field = sLangCrossList.getIndexHashMap()
                }
                return field
            }

        /**
         * id直接作为数组索引
         */
        fun getLangInstant(lang: Lang): Lang? {
            val id = lang.id
            var resLang: Lang? = null
            if (id != null) {
                return getLangById(id)
            } else if (lang.abbr != null) {
//                都不可能为null，要不就是程序代码出错
                return getLangById(this.sIndexHashMap!![lang.abbr]!!)
            }
            return resLang
        }

        fun getSupportLangList(to: Lang, sceneFlag: Int, from: Boolean): List<Lang> {
            val langList = arrayListOf<Lang>()
            val queryLang = getLangInstant(to)
            val list = if (from) {
                sLangCrossList.getOutItemsById(queryLang!!.id!!, sceneFlag)
            } else {
                sLangCrossList.getInItemsById(queryLang!!.id!!, sceneFlag)
            }
            if (sceneFlag == TEXT_TRANS) {
                for (lang in sLangs!!) {
                    var flag = false
                    for (item in list) {
                        if (item.id == lang.id) {
                            flag = true
                        }
                    }
                    if (!flag) {
                        langList.add(lang as Lang)
                    }
                }
            } else {
                for (lang in list) {
                    langList.add(getLangById(lang.id!!)!!)
                }
            }
            return langList
        }

        /**
         * 通过id得到语言
         */
        fun getLangById(id: Int): Lang? {
            return sLangs?.get(id) as Lang
        }

        // rowId colId代表唯一内存索引
        fun createIntern(): LangCrossList {
            val voiceArrList = arrayListOf<ArrayList<LangToLang>>()
            val size = ENGLISH_NAME.size
            val fromLangs = arrayListOf<Lang>()
            val toLangs = arrayListOf<Lang>()

            val ietfSize = IETF.size
            for (rowId in 0 until size) {
                val from = Lang(rowId, ENGLISH_NAME[rowId], LOCAL_NAME[rowId], ABBR[rowId], if (rowId < ietfSize) IETF[rowId] else null)
                fromLangs.add(from)
            }
            for (colId in 0 until size) {
                val to = Lang(colId, ENGLISH_NAME[colId], LOCAL_NAME[colId], ABBR[colId], if (colId < ietfSize) IETF[colId] else null)
                toLangs.add(to)
            }
            val crossList = LangCrossList(fromLangs, toLangs)
//           构造voice
            for (rowId in 0 until ietfSize) {
                val from = Lang(rowId, ENGLISH_NAME[rowId], LOCAL_NAME[rowId], ABBR[rowId], IETF[rowId])
                val list = arrayListOf<LangToLang>()
                for (colId in 0 until ietfSize) {
                    if (colId != rowId) {
                        val to = Lang(colId, ENGLISH_NAME[colId], LOCAL_NAME[colId], ABBR[colId], IETF[rowId])
                        list.add(LangToLang(from, to))
                    }
                }
                voiceArrList.add(list)
            }
            crossList.addOrUpdateAll(voiceArrList, 2)

//           构造文本list
            return crossList
        }

    }
}

fun main() {
    val crossList = LangProvider.sLangCrossList
    println(LangProvider.getLangById(12))
    println(LangProvider.getLangInstant(Lang(abbr = "zh-CN")))
    val supportFromList = LangProvider.getSupportLangList(Lang(abbr = "ur"), 2, true)
    print(1)
}