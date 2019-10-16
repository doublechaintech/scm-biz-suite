

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ReceivingSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (receivingSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{receivingSpace.id}</Description> 
<Description term="位置">{receivingSpace.location}</Description> 
<Description term="联系电话">{receivingSpace.contactNumber}</Description> 
<Description term="描述">{receivingSpace.description}</Description> 
<Description term="总面积">{receivingSpace.totalArea}</Description> 
<Description term="纬度">{receivingSpace.latitude}</Description> 
<Description term="经度">{receivingSpace.longitude}</Description> 
<Description term="最后更新时间">{ moment(receivingSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = receivingSpace => {
  const {ReceivingSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={receivingSpace}  targetObjectMeta={ReceivingSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ReceivingSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  receivingSpace = this.props.receivingSpace
    const { id,displayName, goodsCount } = receivingSpace
    const  returnURL = `/receivingSpace/${id}/dashboard`
    const cardsData = {cardsName:"收货区",cardsFor: "receivingSpace",cardsSource: receivingSpace,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  receivingSpace: state._receivingSpace,
}))(Form.create()(ReceivingSpacePermission))

