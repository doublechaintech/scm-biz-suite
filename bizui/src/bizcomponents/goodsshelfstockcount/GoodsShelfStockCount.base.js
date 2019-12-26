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

const renderItemOfList=(goodsShelfStockCount, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={goodsShelfStockCount.id}>
	
      <DescriptionList  key={goodsShelfStockCount.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.title}</Description> 
        <Description term={fieldLabels.countTime}><div>{ moment(goodsShelfStockCount.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.summary} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.summary}</Description> 
        <Description term={fieldLabels.shelf}><div>{goodsShelfStockCount.shelf==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelfStockCount.shelf.displayName}(${goodsShelfStockCount.shelf.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, shelfId} = formValuesToPack
	const shelf = {id: shelfId, version: 2^31}
	const data = {title, countTime, summary, shelf}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, countTime, summary, shelf} = objectToUnpack
	const shelfId = shelf ? shelf.id : null
	const data = {title, countTime, summary, shelfId}
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
const GoodsShelfStockCountBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsShelfStockCountBase



