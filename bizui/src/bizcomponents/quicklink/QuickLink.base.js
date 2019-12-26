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
const menuData = {menuName:"快速链接", menuFor: "quickLink",
=======

const menuData = {menuName: window.trans('quick_link'), menuFor: "quickLink",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"快速链接", menuFor: "quickLink",
=======
const settingMenuData = {menuName: window.trans('quick_link'), menuFor: "quickLink",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  name: '名称',
  icon: '图标',
  imagePath: '图片路径',
  linkTarget: '链接的目标',
  createTime: '创建时间',
  app: '应用程序',
=======
  id: window.trans('quick_link.id'),
  name: window.trans('quick_link.name'),
  icon: window.trans('quick_link.icon'),
  imagePath: window.trans('quick_link.image_path'),
  linkTarget: window.trans('quick_link.link_target'),
  createTime: window.trans('quick_link.create_time'),
  app: window.trans('quick_link.app'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'quickLink') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '12',render: (text, record)=>renderTextCell(text,record)},
<<<<<<< HEAD
  { title: fieldLabels.imagePath, dataIndex: 'imagePath', render: (text, record) => renderImageCell(text,record,'图片路径') },
=======
  { title: fieldLabels.imagePath, dataIndex: 'imagePath', render: (text, record) => renderImageCell(text,record,'quick_link.image_path') },
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  { title: fieldLabels.linkTarget, debugtype: 'string', dataIndex: 'linkTarget', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderItemOfList=(quickLink,targetComponent)=>{

  const userContext = null
  return (
    <div key={quickLink.id}>
	
<<<<<<< HEAD
      <DescriptionList  key={quickLink.id} size="small" col="4">
        <Description term="ID">{quickLink.id}</Description> 
        <Description term="名称">{quickLink.name}</Description> 
        <Description term="图标">{quickLink.icon}</Description> 
        <Description term="链接的目标">{quickLink.linkTarget}</Description> 
        <Description term="创建时间"><div>{ moment(quickLink.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="应用程序"><div>{quickLink.app==null?appLocaleName(userContext,"NotAssigned"):`${quickLink.app.displayName}(${quickLink.app.id})`}
=======
      <DescriptionList  key={quickLink.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{quickLink.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{quickLink.name}</Description> 
        <Description term={fieldLabels.icon} style={{wordBreak: 'break-all'}}>{quickLink.icon}</Description> 
        <Description term={fieldLabels.linkTarget} style={{wordBreak: 'break-all'}}>{quickLink.linkTarget}</Description> 
        <Description term={fieldLabels.createTime}><div>{ moment(quickLink.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.app}><div>{quickLink.app==null?appLocaleName(userContext,"NotAssigned"):`${quickLink.app.displayName}(${quickLink.app.id})`}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, icon, linkTarget, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, icon, linkTarget, app}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, icon, linkTarget, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, icon, linkTarget, appId}
	return data
}
<<<<<<< HEAD

const QuickLinkBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const QuickLinkBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default QuickLinkBase



