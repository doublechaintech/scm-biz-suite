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
const menuData = {menuName:"一级分类", menuFor: "levelOneCategory",
  		subItems: [
  {name: 'levelTwoCategoryList', displayName:'二级分类', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('level_one_category'), menuFor: "levelOneCategory",
  		subItems: [
  {name: 'levelTwoCategoryList', displayName: window.mtrans('level_two_category','level_one_category.level_two_category_list',false), type:'levelTwoCategory',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"一级分类", menuFor: "levelOneCategory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  catalog: '目录',
  name: '名称',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneCategory') , sorter: true },
  { title: fieldLabels.catalog, dataIndex: 'catalog', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelOneCategory,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelOneCategory.id}>
	
      <DescriptionList  key={levelOneCategory.id} size="small" col="4">
        <Description term="序号">{levelOneCategory.id}</Description> 
        <Description term="目录"><div>{levelOneCategory.catalog==null?appLocaleName(userContext,"NotAssigned"):`${levelOneCategory.catalog.displayName}(${levelOneCategory.catalog.id})`}
        </div></Description>
        <Description term="名称">{levelOneCategory.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, catalogId} = formValuesToPack
	const catalog = {id: catalogId, version: 2^31}
	const data = {name, catalog}
	return data
}
=======

const settingMenuData = {menuName: window.trans('level_one_category'), menuFor: "levelOneCategory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('level_one_category.id'),
  catalog: window.trans('level_one_category.catalog'),
  name: window.trans('level_one_category.name'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneCategory') , sorter: true },
  { title: fieldLabels.catalog, dataIndex: 'catalog', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(levelOneCategory,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelOneCategory.id}>
	
      <DescriptionList  key={levelOneCategory.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{levelOneCategory.id}</Description> 
        <Description term={fieldLabels.catalog}><div>{levelOneCategory.catalog==null?appLocaleName(userContext,"NotAssigned"):`${levelOneCategory.catalog.displayName}(${levelOneCategory.catalog.id})`}
        </div></Description>
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{levelOneCategory.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, catalogId} = formValuesToPack
	const catalog = {id: catalogId, version: 2^31}
	const data = {name, catalog}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, catalog} = objectToUnpack
	const catalogId = catalog ? catalog.id : null
	const data = {name, catalogId}
	return data
}
<<<<<<< HEAD

const LevelOneCategoryBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const LevelOneCategoryBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default LevelOneCategoryBase



