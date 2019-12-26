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
const menuData = {menuName:"目录", menuFor: "catalog",
  		subItems: [
  {name: 'levelOneCategoryList', displayName:'一级分类', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('catalog'), menuFor: "catalog",
  		subItems: [
  {name: 'levelOneCategoryList', displayName: window.mtrans('level_one_category','catalog.level_one_category_list',false), type:'levelOneCategory',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"目录", menuFor: "catalog",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'catalog') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(catalog,targetComponent)=>{

  const userContext = null
  return (
    <div key={catalog.id}>
	
      <DescriptionList  key={catalog.id} size="small" col="4">
        <Description term="序号">{catalog.id}</Description> 
        <Description term="名称">{catalog.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, owner}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, ownerId}
	return data
}

const CatalogBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======

const settingMenuData = {menuName: window.trans('catalog'), menuFor: "catalog",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('catalog.id'),
  name: window.trans('catalog.name'),
  owner: window.trans('catalog.owner'),
  subCount: window.trans('catalog.sub_count'),
  amount: window.trans('catalog.amount'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'catalog') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.subCount, debugtype: 'int', dataIndex: 'subCount', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(catalog,targetComponent)=>{

  const userContext = null
  return (
    <div key={catalog.id}>
	
      <DescriptionList  key={catalog.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{catalog.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{catalog.name}</Description> 
        <Description term={fieldLabels.subCount}><div style={{"color":"red"}}>{catalog.subCount}</div></Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{catalog.amount}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, subCount, amount, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, subCount, amount, owner}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, subCount, amount, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, subCount, amount, ownerId}
	return data
}
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
const CatalogBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default CatalogBase



