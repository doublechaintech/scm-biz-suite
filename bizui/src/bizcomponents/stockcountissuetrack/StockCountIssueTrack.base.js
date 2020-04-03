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
import styles from './StockCountIssueTrack.base.less'
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



const menuData = {menuName: window.trans('stock_count_issue_track'), menuFor: "stockCountIssueTrack",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('stock_count_issue_track'), menuFor: "stockCountIssueTrack",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('stock_count_issue_track.id'),
  title: window.trans('stock_count_issue_track.title'),
  countTime: window.trans('stock_count_issue_track.count_time'),
  summary: window.trans('stock_count_issue_track.summary'),
  stockCount: window.trans('stock_count_issue_track.stock_count'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'stockCountIssueTrack') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countTime, dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.summary, debugtype: 'string', dataIndex: 'summary', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.stockCount, dataIndex: 'stockCount', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(stockCountIssueTrack, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(stockCountIssueTrack, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={stockCountIssueTrack.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(stockCountIssueTrack.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={stockCountIssueTrack.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{stockCountIssueTrack.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{stockCountIssueTrack.title}</Description> 
        <Description term={fieldLabels.countTime}><div>{ moment(stockCountIssueTrack.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.summary} style={{wordBreak: 'break-all'}}>{stockCountIssueTrack.summary}</Description> 
        <Description term={fieldLabels.stockCount}><Tag color='blue' title={`${stockCountIssueTrack.stockCount.id}-${stockCountIssueTrack.stockCount.displayName}`}>{stockCountIssueTrack.stockCount==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(stockCountIssueTrack.stockCount.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, stockCountId} = formValuesToPack
	const stockCount = {id: stockCountId, version: 2^31}
	const data = {title, countTime:moment(countTime).valueOf(), summary, stockCount}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, countTime, summary, stockCount} = objectToUnpack
	const stockCountId = stockCount ? stockCount.id : null
	const data = {title, countTime:moment(countTime), summary, stockCountId}
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
const StockCountIssueTrackBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default StockCountIssueTrackBase

