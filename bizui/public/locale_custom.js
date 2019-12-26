
var customLocaleMessage=[
]

const finalValues=[]

coreLocaleMessage.forEach(item=>{finalValues[item.key]=item;})
customLocaleMessage.forEach(item=>{finalValues[item.key]=item;})

var trans = function( termKey){
	var result = finalValues[termKey];
	if(!result){
		return termKey+" Not Found!"
	}
	return result.chinese
}
var mtrans = function( baseTermKey, extraTermKey, isMuliple){
   
    if(!isMuliple){
        return trans(baseTermKey)
    }
    return `${trans(baseTermKey)}(${trans(extraTermKey)})`
	
}
window.mtrans=mtrans;
window.trans=trans;

















