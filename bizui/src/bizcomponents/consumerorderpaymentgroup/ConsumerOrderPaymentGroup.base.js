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
import styles from './ConsumerOrderPaymentGroup.base.less'
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




const menuData = {menuName: window.trans('consumer_order_payment_group'), menuFor: "consumerOrderPaymentGroup",  internalName: "consumer_order_payment_group",
  		subItems: [

  		],
}


const settingMenuData = {menuName: window.trans('consumer_order_payment_group'), menuFor: "consumerOrderPaymentGroup",  internalName: "consumer_order_payment_group",
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
  id: window.trans('consumer_order_payment_group.id'),
  name: window.trans('consumer_order_payment_group.name'),
  bizOrder: window.trans('consumer_order_payment_group.biz_order'),
  cardNumber: window.trans('consumer_order_payment_group.card_number'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'consumerOrderPaymentGroup') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

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


const renderActionList=(consumerOrderPaymentGroup, targetObject, columCount, listName)=>{

	if(!consumerOrderPaymentGroup){
		return null
	}
	if(!consumerOrderPaymentGroup.actionList){
		return null
	}
	if(consumerOrderPaymentGroup.actionList.length === 0){
		return null
	}
	return (
		<div className={styles.overlay}>

			<div className={styles.overlayContent}>
			{consumerOrderPaymentGroup.actionList.map(action=>(<Link key={action.id} to={{pathname: action.actionPath.substring(1), state: {ownerId:targetObject.id,action,selectedRows:[consumerOrderPaymentGroup]}}} >
				<span className={styles.overlayText}>{action.actionName}</span>
				</Link> ))}
			</div>

		</div>
		)

}

const renderItemOfList=(consumerOrderPaymentGroup, targetObject, columCount, listName)=>{

  if(!consumerOrderPaymentGroup){
  	return null
  }
  if(!consumerOrderPaymentGroup.id){
  	return null
  }


  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
     <Row key={`${listName}-${consumerOrderPaymentGroup.id}`} className={styles.itemDesc}>

	<Col span={4}>
		<Avatar size={90} className={styles.avarta} style={{ backgroundColor: genColor()}}>
			{leftChars(consumerOrderPaymentGroup.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  



      <DescriptionList  key={consumerOrderPaymentGroup.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderPaymentGroup.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{consumerOrderPaymentGroup.name}</Description> 
        <Description term={fieldLabels.bizOrder}>{renderReferenceItem(consumerOrderPaymentGroup.bizOrder)}</Description>

        <Description term={fieldLabels.cardNumber} style={{wordBreak: 'break-all'}}>{consumerOrderPaymentGroup.cardNumber}</Description> 


      </DescriptionList>
     </Col>
      {renderActionList(consumerOrderPaymentGroup,targetObject)}
    </Row>
	)

}

const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, bizOrderId, cardNumber} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {name, bizOrder, cardNumber}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, bizOrder, cardNumber} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {name, bizOrderId, cardNumber}
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



const ConsumerOrderPaymentGroupBase={unpackObjectToFormValues, menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ConsumerOrderPaymentGroupBase

