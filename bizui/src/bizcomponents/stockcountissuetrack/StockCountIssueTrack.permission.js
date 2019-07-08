

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './StockCountIssueTrack.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (stockCountIssueTrack,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{stockCountIssueTrack.id}</Description> 
<Description term="Title">{stockCountIssueTrack.title}</Description> 
<Description term="Count Time">{ moment(stockCountIssueTrack.countTime).format('YYYY-MM-DD')}</Description> 
<Description term="Summary">{stockCountIssueTrack.summary}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = stockCountIssueTrack => {
  const {StockCountIssueTrackBase} = GlobalComponents
  return <PermissionSetting targetObject={stockCountIssueTrack}  targetObjectMeta={StockCountIssueTrackBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class StockCountIssueTrackPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  stockCountIssueTrack = this.props.stockCountIssueTrack;
    const { id,displayName,  } = stockCountIssueTrack
    const cardsData = {cardsName:"Stock Count Issue Track",cardsFor: "stockCountIssueTrack",cardsSource: stockCountIssueTrack,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  stockCountIssueTrack: state._stockCountIssueTrack,
}))(Form.create()(StockCountIssueTrackPermission))

