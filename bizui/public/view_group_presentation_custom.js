
// import coreViewGroupPresentData from 'view_group_presentation_core'
var customViewGroupPresentData=[
  { owner: 'retail_store_country_center', viewGroupName: '产品管理', newViewGroupName:'产品管理(改)' ,iconName: 'caret-right', presentOrder: 1 },

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
function viewGroupDisplayNameOf( owner, viewGroupName){
	const key = keyOf(owner,viewGroupName)
	const result = finalItemValues[key]

	if(!result){
		return "folder"
	}

	return result.newViewGroupName;
}

window.viewGroupDisplayNameOf=viewGroupDisplayNameOf;
window.viewGroupIconNameOf=viewGroupIconNameOf;
window.viewGroupItemOf=viewGroupItemOf;






