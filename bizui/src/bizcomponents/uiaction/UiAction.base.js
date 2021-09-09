import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Row, Tag, Button,Table} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './UiAction.base.less'
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
	defaultRenderNumberCell,
	defaultFormatNumber,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell
const renderNumberCell=defaultRenderNumberCell
const formatNumber = defaultFormatNumber

const renderImageListCell=(imageList, record)=>{
	const userContext = null;
	if(!imageList){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(imageList.length === 0){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return (<span>{
		imageList.map(item=>(<img width="40px" key={item.id} title={item.title} src={item.imageUrl}/>))
		}</span>)
}




const menuData = {menuName: window.trans('ui_action'), menuFor: "uiAction",  internalName: "ui_action",
  		subItems: [

  		],
}


const settingMenuData = {menuName: window.trans('ui_action'), menuFor: "uiAction",  internalName: "ui_action",
  		subItems: [

  		],
}


const mergedSubItems=()=>{

    const result = []
    menuData.subItems.forEach(item=>{
        result.push({...item, for: "menu"})
    })
    settingMenuData.subItems.forEach(item=>{
        result.push({...item, for: "setting"})
    })
    return result
}
const universalMenuData = {...menuData, subItems: mergedSubItems()}



const fieldLabels = {
  id: window.trans('ui_action.id'),
  code: window.trans('ui_action.code'),
  icon: window.trans('ui_action.icon'),
  title: window.trans('ui_action.title'),
  displayOrder: window.trans('ui_action.display_order'),
  brief: window.trans('ui_action.brief'),
  imageUrl: window.trans('ui_action.image_url'),
  linkToUrl: window.trans('ui_action.link_to_url'),
  extraData: window.trans('ui_action.extra_data'),
  page: window.trans('ui_action.page'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'uiAction') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.displayOrder, dataIndex: 'displayOrder', className:'money', render: (text, record) => renderNumberCell(text, record, 0), sorter: true  },
  { title: fieldLabels.brief, debugtype: 'string', dataIndex: 'brief', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.imageUrl, dataIndex: 'imageUrl', render: (text, record) => renderImageCell(text,record,'ui_action.image_url') },
  { title: fieldLabels.linkToUrl, debugtype: 'string', dataIndex: 'linkToUrl', width: '33',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.extraData, debugtype: 'string_longtext', dataIndex: 'extraData', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.page, dataIndex: 'page', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(universalMenuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}

	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}


const renderImageList=(imageList,label, targetComponent)=>{
	const userContext = null
	if(!imageList){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(imageList.length === 0){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	// return JSON.stringify(imageList)
/*
	the data looks like this
	{"id":"1601","title":"cover_images01",
	"imageUrl":"https://demo.doublechaintech.com/demodata/imageManager/genImage/cover_images010016/400/200/grey/"},
	{"id":"1602","title":"cover_images02",
	"imageUrl":"https://demo.doublechaintech.com/demodata/imageManager/genImage/cover_images020016/400/200/grey/"}
*/
	return (<span>{
		imageList.map(item=>(<img width="40px" key={item.id} title={item.title} src={item.imageUrl}/>))
		}</span>)

}


const renderActionList=(uiAction, targetObject, columCount, listName)=>{

	if(!uiAction){
		return null
	}
	if(!uiAction.actionList){
		return null
	}
	if(uiAction.actionList.length === 0){
		return null
	}
	return (
		<div className={styles.overlay}>

			<div className={styles.overlayContent}>
			{uiAction.actionList.map(action=>(<Link key={action.id} to={{pathname: action.actionPath.substring(1), state: {ownerId:targetObject.id,action,selectedRows:[uiAction]}}} >
				<span className={styles.overlayText}>{action.actionName}</span>
				</Link> ))}
			</div>

		</div>
		)

}

const renderItemOfList=(uiAction, targetObject, columCount, listName)=>{

  if(!uiAction){
  	return null
  }
  if(!uiAction.id){
  	return null
  }


  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
     <Row key={`${listName}-${uiAction.id}`} className={styles.itemDesc}>

	<Col span={4}>
		<Avatar size={90} className={styles.avarta} style={{ backgroundColor: genColor()}}>
			{leftChars(uiAction.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  



      <DescriptionList  key={uiAction.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{uiAction.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{uiAction.code}</Description> 
        <Description term={fieldLabels.icon} style={{wordBreak: 'break-all'}}>{uiAction.icon}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{uiAction.title}</Description> 
        <Description term={fieldLabels.displayOrder}><div style={{"color":"red"}}>{formatNumber(uiAction.displayOrder,0)}</div></Description> 
        <Description term={fieldLabels.brief} style={{wordBreak: 'break-all'}}>{uiAction.brief}</Description> 
        <Description term={fieldLabels.imageUrl}><div><ImagePreview imageTitle={fieldLabels.imageUrl} imageLocation={uiAction.imageUrl}/></div></Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{uiAction.linkToUrl}</Description> 
        <Description term={fieldLabels.page}>{renderReferenceItem(uiAction.page)}</Description>



      </DescriptionList>
     </Col>
      {renderActionList(uiAction,targetObject)}
    </Row>
	)

}

const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, icon, title, displayOrder, brief, imageUrl, linkToUrl, extraData, pageId} = formValuesToPack
	const page = {id: pageId, version: 2^31}
	const data = {code, icon, title, displayOrder, brief, imageUrl, linkToUrl, extraData, page}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, icon, title, displayOrder, brief, imageUrl, linkToUrl, extraData, page} = objectToUnpack
	const pageId = page ? page.id : null
	const data = {code, icon, title, displayOrder, brief, imageUrl, linkToUrl, extraData, pageId}
	return data
}


const stepOf=(targetComponent, title, content, position, index, initValue)=>{
	const isMultipleEvent=false
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
		initValue,
		isMultipleEvent,
      }
}



const UiActionBase={unpackObjectToFormValues, menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default UiActionBase

