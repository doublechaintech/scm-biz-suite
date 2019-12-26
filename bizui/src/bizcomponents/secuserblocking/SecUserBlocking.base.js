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
const menuData = {menuName:"用户屏蔽", menuFor: "secUserBlocking",
  		subItems: [
  {name: 'secUserList', displayName:'安全用户', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('sec_user_blocking'), menuFor: "secUserBlocking",
  		subItems: [
  {name: 'secUserList', displayName: window.mtrans('sec_user','sec_user_blocking.sec_user_list',false), type:'secUser',icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"用户屏蔽", menuFor: "secUserBlocking",
=======
const settingMenuData = {menuName: window.trans('sec_user_blocking'), menuFor: "secUserBlocking",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  who: '谁',
  blockTime: '时间',
  comments: '评论',
=======
  id: window.trans('sec_user_blocking.id'),
  who: window.trans('sec_user_blocking.who'),
  blockTime: window.trans('sec_user_blocking.block_time'),
  comments: window.trans('sec_user_blocking.comments'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'secUserBlocking') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.blockTime, dataIndex: 'blockTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '28',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(secUserBlocking,targetComponent)=>{

  const userContext = null
  return (
    <div key={secUserBlocking.id}>
	
      <DescriptionList  key={secUserBlocking.id} size="small" col="4">
        <Description term="ID">{secUserBlocking.id}</Description> 
        <Description term="谁">{secUserBlocking.who}</Description> 
        <Description term="时间"><div>{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="评论">{secUserBlocking.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, comments} = formValuesToPack

	const data = {who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, comments} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(secUserBlocking,targetComponent)=>{

  const userContext = null
  return (
    <div key={secUserBlocking.id}>
	
      <DescriptionList  key={secUserBlocking.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{secUserBlocking.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{secUserBlocking.who}</Description> 
        <Description term={fieldLabels.blockTime}><div>{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{secUserBlocking.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, comments} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, comments} = objectToUnpack

<<<<<<< HEAD
const SecUserBlockingBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, comments}
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
const SecUserBlockingBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default SecUserBlockingBase



