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



const menuData = {menuName: window.trans('slide'), menuFor: "slide",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('slide'), menuFor: "slide",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('slide.id'),
  displayOrder: window.trans('slide.display_order'),
  name: window.trans('slide.name'),
  imageUrl: window.trans('slide.image_url'),
  videoUrl: window.trans('slide.video_url'),
  linkToUrl: window.trans('slide.link_to_url'),
  page: window.trans('slide.page'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'slide') , sorter: true },
  { title: fieldLabels.displayOrder, debugtype: 'int', dataIndex: 'displayOrder', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.imageUrl, dataIndex: 'imageUrl', render: (text, record) => renderImageCell(text,record,'slide.image_url') },
  { title: fieldLabels.videoUrl, dataIndex: 'videoUrl', render: (text, record) => renderImageCell(text,record,'slide.video_url') },
  { title: fieldLabels.linkToUrl, debugtype: 'string', dataIndex: 'linkToUrl', width: '21',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.page, dataIndex: 'page', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(slide, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={slide.id}>
	
      <DescriptionList  key={slide.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{slide.id}</Description> 
        <Description term={fieldLabels.displayOrder}><div style={{"color":"red"}}>{slide.displayOrder}</div></Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{slide.name}</Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{slide.linkToUrl}</Description> 
        <Description term={fieldLabels.page}><div>{slide.page==null?appLocaleName(userContext,"NotAssigned"):`${slide.page.displayName}(${slide.page.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {displayOrder, name, linkToUrl, pageId} = formValuesToPack
	const page = {id: pageId, version: 2^31}
	const data = {displayOrder, name, linkToUrl, page}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {displayOrder, name, linkToUrl, page} = objectToUnpack
	const pageId = page ? page.id : null
	const data = {displayOrder, name, linkToUrl, pageId}
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
const SlideBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SlideBase



