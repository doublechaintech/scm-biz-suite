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



const menuData = {menuName: window.trans('member_wishlist'), menuFor: "memberWishlist",
  		subItems: [
  {name: 'memberWishlistProductList', displayName: window.mtrans('member_wishlist_product','member_wishlist.member_wishlist_product_list',false), type:'memberWishlistProduct',icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('member_wishlist'), menuFor: "memberWishlist",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('member_wishlist.id'),
  name: window.trans('member_wishlist.name'),
  owner: window.trans('member_wishlist.owner'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'memberWishlist') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(memberWishlist,targetComponent)=>{

  const userContext = null
  return (
    <div key={memberWishlist.id}>
	
      <DescriptionList  key={memberWishlist.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{memberWishlist.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{memberWishlist.name}</Description> 
        <Description term={fieldLabels.owner}><div>{memberWishlist.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberWishlist.owner.displayName}(${memberWishlist.owner.id})`}
        </div></Description>
	
        
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
const MemberWishlistBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default MemberWishlistBase



