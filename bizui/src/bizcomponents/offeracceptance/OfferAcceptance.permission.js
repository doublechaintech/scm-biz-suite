

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './OfferAcceptance.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (offerAcceptance,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{offerAcceptance.id}</Description> 
<Description term="谁">{offerAcceptance.who}</Description> 
<Description term="接受时间">{ moment(offerAcceptance.acceptTime).format('YYYY-MM-DD')}</Description> 
<Description term="评论">{offerAcceptance.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = offerAcceptance => {
  const {OfferAcceptanceBase} = GlobalComponents
  return <PermissionSetting targetObject={offerAcceptance}  targetObjectMeta={OfferAcceptanceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OfferAcceptancePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  offerAcceptance = this.props.offerAcceptance
    const { id,displayName, employeeCount } = offerAcceptance
    const  returnURL = `/offerAcceptance/${id}/dashboard`
    const cardsData = {cardsName:"接受工作要约",cardsFor: "offerAcceptance",cardsSource: offerAcceptance,displayName,returnURL,
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
  offerAcceptance: state._offerAcceptance,
}))(Form.create()(OfferAcceptancePermission))

