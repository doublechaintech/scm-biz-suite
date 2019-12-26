import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList

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

const renderItemOfList=(stockCountIssueTrack, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={stockCountIssueTrack.id}>
	
      <DescriptionList  key={stockCountIssueTrack.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{stockCountIssueTrack.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{stockCountIssueTrack.title}</Description> 
        <Description term={fieldLabels.countTime}><div>{ moment(stockCountIssueTrack.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.summary} style={{wordBreak: 'break-all'}}>{stockCountIssueTrack.summary}</Description> 
        <Description term={fieldLabels.stockCount}><div>{stockCountIssueTrack.stockCount==null?appLocaleName(userContext,"NotAssigned"):`${stockCountIssueTrack.stockCount.displayName}(${stockCountIssueTrack.stockCount.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, stockCountId} = formValuesToPack
	const stockCount = {id: stockCountId, version: 2^31}
	const data = {title, countTime, summary, stockCount}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, countTime, summary, stockCount} = objectToUnpack
	const stockCountId = stockCount ? stockCount.id : null
	const data = {title, countTime, summary, stockCountId}
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
const StockCountIssueTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default StockCountIssueTrackBase



