import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './GoodsShelfStockCount.base.less'
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



const menuData = {menuName: window.trans('goods_shelf_stock_count'), menuFor: "goodsShelfStockCount",
  		subItems: [
  {name: 'stockCountIssueTrackList', displayName: window.mtrans('stock_count_issue_track','goods_shelf_stock_count.stock_count_issue_track_list',false), type:'stockCountIssueTrack',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('goods_shelf_stock_count'), menuFor: "goodsShelfStockCount",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_shelf_stock_count.id'),
  title: window.trans('goods_shelf_stock_count.title'),
  countTime: window.trans('goods_shelf_stock_count.count_time'),
  summary: window.trans('goods_shelf_stock_count.summary'),
  shelf: window.trans('goods_shelf_stock_count.shelf'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelfStockCount') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countTime, dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.summary, debugtype: 'string', dataIndex: 'summary', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.shelf, dataIndex: 'shelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
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

const renderReferenceItem=(value, targetComponent)=>{
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
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(goodsShelfStockCount, targetComponent, columCount)=>{
  
  if(!goodsShelfStockCount){
  	return null
  }
  if(!goodsShelfStockCount.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`goodsShelfStockCount-${goodsShelfStockCount.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(goodsShelfStockCount.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={goodsShelfStockCount.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.title}</Description> 
        <Description term={fieldLabels.countTime}><div>{ moment(goodsShelfStockCount.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.summary} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.summary}</Description> 
        <Description term={fieldLabels.shelf}>{renderReferenceItem(goodsShelfStockCount.shelf)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, shelfId} = formValuesToPack
	const shelf = {id: shelfId, version: 2^31}
	const data = {title, countTime:moment(countTime).valueOf(), summary, shelf}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, countTime, summary, shelf} = objectToUnpack
	const shelfId = shelf ? shelf.id : null
	const data = {title, countTime:moment(countTime), summary, shelfId}
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
const GoodsShelfStockCountBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsShelfStockCountBase

