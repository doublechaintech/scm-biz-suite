
// import 'coreLocaleMessage' from 'locale_core'
const customLocaleMessage=[
]

const finalValues=[]

coreLocaleMessage.forEach(item=>{finalValues[item.key]=item;})
customLocaleMessage.forEach(item=>{finalValues[item.key]=item;})

function trans ( termKey){
	var result = finalValues[termKey];
	if(!result){
		return termKey+" Not Found!"
	}
	return result.chinese
}

function mtrans ( baseTermKey, extraTermKey, isMuliple){

    if(!isMuliple){
        return trans(baseTermKey)
    }
    return `${trans(baseTermKey)}(${trans(extraTermKey)})`

}

window.mtrans=mtrans;
window.trans=trans;






































