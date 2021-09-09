
// import coreViewGroupPresentData from 'view_group_presentation_core'
var customViewGroupPresentData=[
]

const finalItemValues=[]

function keyOf(owner, viewGroupName){
	return owner+":"+viewGroupName;
}

coreViewGroupPresentData.forEach(item=>{finalItemValues[keyOf(item.owner,item.viewGroupName)]=item;})
customViewGroupPresentData.forEach(item=>{finalItemValues[keyOf(item.owner,item.viewGroupName)]=item;})


function viewGroupItemOf( owner, viewGroupName){
	const key = keyOf(owner,viewGroupName)
	const result = finalItemValues[key];
	if(!result){
		return {iconName:"folder"}
	}
	return result
}

function viewGroupIconNameOf( owner, viewGroupName){
	const key = keyOf(owner,viewGroupName)
	const result = finalItemValues[key]

	if(!result){
		return "folder"
	}

	return result.iconName
}



window.viewGroupIconNameOf=viewGroupIconNameOf;
window.viewGroupItemOf=viewGroupItemOf;






