import enUS from './en_US'
import zhCN from './zh_CN'
import ruRU from './ru_RU'

const defaultMessageSet = zhCN;
let   currentMessageSet = defaultMessageSet;

const localeSet = {
    "enUS":{ title: "English US",messages: enUS},
    "zhCN":{ title: "中文",messages: zhCN},
    "ruRU":{ title: "русский",messages: ruRU},
    
    
};
const switchLanguage =(selectLocale)=>{
    const locale = localeSet[selectLocale];
    if(locale){
        currentMessageSet = locale.messages
        return;
    }
    log(`Could not switch to locale ${selectLocale}`);

}

const i18n =(messageKey)=>{
   
    const msg = currentMessageSet[messageKey];
    if(!msg){
        return messageKey;
    }
    return msg;

}

const Locale = {
    switchLanguage,i18n
};

export default Locale;