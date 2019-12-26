import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"二级分类", menuFor: "levelTwoCategory",
  		subItems: [
  {name: 'levelThreeCategoryList', displayName:'三级分类', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('level_two_category'), menuFor: "levelTwoCategory",
  		subItems: [
  {name: 'levelThreeCategoryList', displayName: window.mtrans('level_three_category','level_two_category.level_three_category_list',false), type:'levelThreeCategory',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"二级分类", menuFor: "levelTwoCategory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  parentCategory: '父类',
  name: '名称',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelTwoCategory') , sorter: true },
  { title: fieldLabels.parentCategory, dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelTwoCategory,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelTwoCategory.id}>
	
      <DescriptionList  key={levelTwoCategory.id} size="small" col="4">
        <Description term="序号">{levelTwoCategory.id}</Description> 
        <Description term="父类"><div>{levelTwoCategory.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${levelTwoCategory.parentCategory.displayName}(${levelTwoCategory.parentCategory.id})`}
        </div></Description>
        <Description term="名称">{levelTwoCategory.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, parentCategoryId} = formValuesToPack
	const parentCategory = {id: parentCategoryId, version: 2^31}
	const data = {name, parentCategory}
	return data
}
=======

const settingMenuData = {menuName: window.trans('level_two_category'), menuFor: "levelTwoCategory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('level_two_category.id'),
  parentCategory: window.trans('level_two_category.parent_category'),
  name: window.trans('level_two_category.name'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelTwoCategory') , sorter: true },
  { title: fieldLabels.parentCategory, dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(levelTwoCategory,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelTwoCategory.id}>
	
      <DescriptionList  key={levelTwoCategory.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{levelTwoCategory.id}</Description> 
        <Description term={fieldLabels.parentCategory}><div>{levelTwoCategory.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${levelTwoCategory.parentCategory.displayName}(${levelTwoCategory.parentCategory.id})`}
        </div></Description>
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{levelTwoCategory.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, parentCategoryId} = formValuesToPack
	const parentCategory = {id: parentCategoryId, version: 2^31}
	const data = {name, parentCategory}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, parentCategory} = objectToUnpack
	const parentCategoryId = parentCategory ? parentCategory.id : null
	const data = {name, parentCategoryId}
	return data
}
<<<<<<< HEAD

const LevelTwoCategoryBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const LevelTwoCategoryBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default LevelTwoCategoryBase



